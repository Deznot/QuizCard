import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer {
    private JFrame frame;
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JButton nextButton;
    private boolean isShowAnswer;
    private QuizCard currentCard;
    private int currentCardIndex = 0;

    public static void main (String[] args) {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    public void go() {
        //формируем и выводим на экран GUI
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif",Font.BOLD, 24);

        display = new JTextArea(10,23);
        display.setLineWrap(true);
        display.setEditable(false);
        display.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,500);
        frame.setVisible(true);
    }

    class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Если это вопрос, показываем ответ, иначе показываем следующий вопрос.
            //Устанавливаем флаг для того, что мы видим, - вопрос это или ответ.
            if (isShowAnswer) {
                //показываем ответ, т.к. вопрос уже был показан
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                //показываем следующий вопрос
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    //Больше карточек нет
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }

    class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Вызываем диалоговое окно, позволяющее пользователю выбрать какой набор карточек открыть
        }
    }

    private void loadFile(File file) {
        /*Cоздает ArrayList с карточками, считывая их из текстового файла вызванного из обработчика событий класса
        OpenMenuListener, читает файл по одной строке за раз и вызывает метод MakeCard() для создания новой карточки из строки
        (одна строка файла содержит вопрос и ответ разделенные символом /)

        */
    }

    private void makeCard (String LineToParse) {
        /*Вызывается методом loadFile, берет строку из текстового файла, делит ее на две части - вопрос и ответ,
        и создает новый объект QuizCard, а затем добавляет его в ArrayList при помощи CardList.
        */
    }

}