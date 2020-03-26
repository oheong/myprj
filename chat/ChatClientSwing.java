package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatClientSwing extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea textArea;
	private JTextField inputTextField;
	private JButton sendButton;

	private ChatConnect chatConnect;
	private String name;

	public ChatClientSwing(String ip, int port) {
		chatConnect = new ChatConnect(this, ip, port, name);
		createUI();
	}

	public ChatConnect getChatConnect() {
		return chatConnect;
	}

	private void createUI() {
		textArea = new JTextArea(20, 50);
		textArea.setEditable(false);// 내용수정불가능하게 해줌
		textArea.setLineWrap(true);// 자동 줄바꿈해줌
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		Box box = Box.createHorizontalBox();
		add(box, BorderLayout.SOUTH);// 남쪽 = 아래쪽
		inputTextField = new JTextField();
		sendButton = new JButton("Send");
		box.add(inputTextField);
		box.add(sendButton);

		// ActionListener인터페이스 상속하여 익명클래스 선언하는 부분
		ActionListener sendListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 사용자 입력 값
				String str = inputTextField.getText();
				if (str != null && str.trim().length() > 0) {

					// 코드를 함께 작성해 봅시다.
					chatConnect.send(str);

				}
				inputTextField.selectAll();
				inputTextField.requestFocus();
				inputTextField.setText("");
			}
		};

		inputTextField.addActionListener(sendListener);// 인풋창에서엔터칠때동작
		sendButton.addActionListener(sendListener);// 버튼클릭할때동작

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {// 윈도우 x(닫기) 버튼 눌렀을때 동작

				// 코드를 함께 작성해 봅시다.
				chatConnect.sendExit();

			}
		});
	}

	public void updateChat(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
}