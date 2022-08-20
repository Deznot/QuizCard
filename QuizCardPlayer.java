public class QuizCardPlayer {
    public void go() {
        //формируем и выводим на экран GUI
    }

    class NextCardListener implements ActionListener {
        public void ActionPerformed(ActionEvent ev) {
            //Если это вопрос, показываем ответ, иначе показываем следующий вопрос.
            //Устанавливаем флаг для того, что мы видим, - вопрос это или ответ.
        }
    }

    class OpenMenuListener implements ActionListener {
        public void ActionPerformed(ActionEvent ev) {
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