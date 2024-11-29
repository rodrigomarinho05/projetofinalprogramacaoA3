import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListarEstoqueFrame extends JFrame {
    public ListarEstoqueFrame() {
        setTitle("Listar Estoque");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (SecondMain.estoque.isEmpty()) {
            textArea.setText("O estoque está vazio.");
        } else {
            for (Produto produto : SecondMain.estoque) {
                textArea.append(produto.toString() + "\n");
            }
        }

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}