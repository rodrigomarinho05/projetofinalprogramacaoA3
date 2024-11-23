import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarProdutoFrame extends JFrame {
    public BuscarProdutoFrame() {
        setTitle("Buscar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextField nomeField = new JTextField();
        JButton buscarButton = new JButton("Buscar");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                boolean encontrado = false;
                textArea.setText("");

                for (Produto produto : Main.estoque) {
                    if (produto.getNome().equalsIgnoreCase(nome)) {
                        textArea.append(produto.toString() + "\n");
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    textArea.setText("Produto não encontrado.");
                }
            }
        });

        add(nomeField, BorderLayout.NORTH);
        add(buscarButton, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }
}