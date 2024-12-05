package view;

import controller.LoginController;
import model.UsuarioDAO;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnLogin;

    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 30, 150, 25);
        add(txtUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(30, 70, 80, 25);
        add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(120, 70, 150, 25);
        add(txtContraseña);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(100, 120, 100, 30);
        add(btnLogin);
    }

    public String getUsuario() {
        return txtUsuario.getText();
    }

    public String getContraseña() {
        return new String(txtContraseña.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            LoginView loginView = new LoginView();
            new LoginController(loginView, usuarioDAO);

            loginView.setVisible(true);
        });
    }
}
