import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class QuizCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;

    public static void main(String args[]) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go() {
        //формирование и вывод на экран GUI, включая создание и регистрация слушателей событий
        
        //Формируем GUI
        frame = new JFrame();
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif",Font.BOLD, 24);
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");

        cardList = new ArrayList<QuizCard>();

        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setVisible(true);

    }

    public class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Слушатель срабатывает при нажатии пользователя на кнопку nextCard
            //Добавляем текущую карточку в список и очищаем текстовые области
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }

    public class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Вызываем диалоговое окно позволяющее пользователю называть и сохранять набор.
            //Запускается при выборе Save из меню. Озн. что пользователь хочет сохранить все карточки в текущем списке
            //ввиде набора ex. Набор английских слов..
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            SaveFile(fileSave.getSelectedFile());
        }
    }
    
    public class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Очищаем список карточек и текстовые облости. 
            //Запускается при нажатии New из меню.
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }


    private void SaveFile(File file) {
        //Вызывается классом SaveMenuListener
        //Проходим по списку карточек и записываем каждый элемент в текстовый файл, который потом можно будет прочесть.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();

        } catch (IOException ex) {
            System.out.println("couldn't write the cardList out");
            ex.printStackTrace();
        }
    }
}