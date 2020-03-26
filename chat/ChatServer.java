package chat;

import java.io.*;
import java.net.*;
import java.util.*;

class User {
	String userID;
	String userPwd;
	String userNm;

	User(String userId, String userPwd, String userNm) {
		this.userID = userId;
		this.userPwd = userPwd;
		this.userNm = userNm;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o instanceof User) {
			User other = (User) o;
			if (this.userID.equals(other.userID) && this.userPwd.equals(other.userPwd))
				return true;
		}
		return false;
	}
}

public class ChatServer {
	// 사용자 데이터베이스
	private ArrayList<User> userDB = new ArrayList<User>();

	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>();
	private int port = 4101;

	public void service() {
		// 가상의 사용자 데이터 베이스 입력
		userDB.add(new User("u1", "p1", "SSAFY"));
		userDB.add(new User("u2", "p2", "구미"));
		userDB.add(new User("u3", "p3", "삼성"));

		try (ServerSocket ss = new ServerSocket(port);) {

			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {
				Socket s = ss.accept();
				System.out.println("ChatClient가 접속했습니다.");

				// 사용자 입력된 데이터가 회원에 존재하는지 체크
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

				// 사용자가 보내준 아이디와 패스워드 체크
				String message = (String) ois.readObject();
				String[] userInfo = message.split(",");

				// index가 -1 이라면 리스트에 없는것.
				// -1이 아니라면 리스트에 존재
				int index = userDB.indexOf(new User(userInfo[0], userInfo[1], ""));
				// 로그인 성공
				if (index != -1) {
					oos.writeObject("Accept:" + userDB.get(index).userNm);
					ChatThread t = new ChatThread(s, ois, oos); // 관리자 리스트
					chatThreadList.add(t);
					t.start();
				}
				// 로그인 실패
				else {
					oos.writeObject("NotAccept");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void broadcast(String message) {
		// 코드를 함께 작성해 봅시다.
		for (ChatThread t : chatThreadList) {
			try {
				t.sendMessage(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ChatServer().service();
	}

	class ChatThread extends Thread {

		private Socket socket;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit = false;

		public ChatThread(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
			this.socket = socket;
//			this.ois = new ObjectInputStream(socket.getInputStream());
//			this.oos = new ObjectOutputStream(socket.getOutputStream());
			this.ois = ois;
			this.oos = oos;
		}

		public void run() {
			try {
				while (!isExit) {

					// 코드를 함께 작성해 봅시다.
					String msg = (String) ois.readObject();

					if ("^".contentEquals(msg)) {
						chatThreadList.remove(this);
						isExit = true;
					} else {
						broadcast(msg);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				chatThreadList.remove(this);
			}
		}

		public void sendMessage(String message) throws Exception {
			// 코드를 함께 작성해 봅시다.
			oos.writeObject(message);
		}
	}
}