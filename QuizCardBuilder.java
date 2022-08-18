class QuizCardBuilder {
    public void go () {
        //формирование и вывод на экран GUI, включая создание и регистрация слушателей событий
    }

    private class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Слушатель срабатывает при нажатии пользователя на кнопку nextCard
            //Добавляем текущую карточку в список и очищаем текстовые области
        }
    }

    private class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Вызываем диалоговое окно позволяющее пользователю называть и сохранять набор.
            //Запускается при выборе Save из меню. Озн. что пользователь хочет сохранить все карточки в текущем списке
            //ввиде набора ex. Набор английских слов..
        }
    }
    
    private class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            //Очищаем список карточек и текстовые облости. 
            //Запускается при нажатии New из меню.
        }
    }

    private void SaveFile(File file) {
        //Вызывается классом SaveMenuListener
        //Проходим по списку карточек и записываем каждый элемент в текстовый файл, который потом можно будет прочесть.
    }
}