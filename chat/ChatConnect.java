package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatConnect {
	private String ip;
	private int port;
	private String name;
	private Socket s;

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ChatClientSwing ui;

	public ChatConnect(ChatClientSwing ui, String ip, int port, String name) {
		this.ui = ui;
		this.ip = ip;
		this.port = port;
		this.name = name;
		// connect();
	}

	public void setName(String name) {
		this.name = name;
	}

	// 사용자 로그인 창에서 입력한 아이다와 패스워드가 서버에 있는지 로그인 체크 : 서버로 입력한 내용을 전송
	public boolean login(String userId, String userPwd) {
		try {
			s = new Socket(ip, port);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());

			// 서버에 id와 pwd를 전송
			oos.writeObject(userId + "," + userPwd);

			// 서버에서 로그인 결과를 확인
			String result = (String) ois.readObject();
			System.out.println(result);
			// 로그인 성공
			if (result.startsWith("Accept:")) {
				this.name = result.split(":")[1]; // 이름
				// 와 이거를 이렇게 쓴다고? 신기하다 자바,,
				ready();
				return true;
			}
			// 로그인 실패
			else {
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return false;
	}

	public void ready() {
		try {
//			s = new Socket(ip, port);
//			oos = new ObjectOutputStream(s.getOutputStream());
//			ois = new ObjectInputStream(s.getInputStream());
//			연결하는 코드인데, 이거 로그인에서 이미 했음

			new Thread() {
				public void run() {
					try {
						while (true) {
							String message = (String) ois.readObject();
							ui.updateChat(message);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String msg) {
		try {

			// 코드를 함께 작성해 봅시다.
			// [사용자 이름] 메세지 형태로
			oos.writeObject("[" + name + "]" + msg);

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void sendExit() {
		try {
			oos.writeObject("^");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
