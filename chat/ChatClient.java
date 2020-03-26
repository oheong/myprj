package chat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChatClient {

	public static void main(String[] args) {
		String ip = "localhost";
		int port = 4101;

		ChatClientSwing ui = new ChatClientSwing(ip, port);
		ui.setTitle("SSAFY V1 - connected to " + ip + ":" + port);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ui.setsize(500,300) //창 크기를 지정해줄 수 있음
		ui.pack();// 요소들의 크기만큼 자동으로 창 크기 설정됨
		ui.setLocationRelativeTo(null);// 화면의 중앙에 창을 띄움
		ui.setResizable(false);// 창크기조절불가능
		// ui.setVisible(true);//창을 화면에 보이게 함

		// String name = JOptionPane.showInputDialog("이름을 입력하세요.");
		// ui.getChatConnect().setName(name);

		JTextField username = new JTextField();
		JTextField password = new JTextField();

		Object[] message = { "Username:", username, "Password:", password };

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		System.out.println(option);

		if (option == JOptionPane.OK_OPTION) {
			String userId = username.getText();
			String userPwd = password.getText();
			if (ui.getChatConnect().login(userId, userPwd)) {
				System.out.println("Login successed");
				ui.setVisible(true);
			} else {
				System.out.println("Login failed");
				ui.getChatConnect().sendExit();
			}
		} else
			System.out.println("Login canceled");
	}
}
