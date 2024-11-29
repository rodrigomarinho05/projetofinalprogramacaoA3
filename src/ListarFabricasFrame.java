import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListarFabricasFrame extends JFrame {
    public ListarFabricasFrame() {
        setTitle("Listar Fabricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.fabricas.isEmpty()) {
            textArea.setText("O Fabricas está vazio.");
        } else {
            for (Fabrica fabrica : Main.fabricas) {
                textArea.append(fabrica.getNome() + "\n");
            }
        }

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}