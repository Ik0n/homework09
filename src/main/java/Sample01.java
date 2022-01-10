/**
 * Основной класс
 */
public class Sample01 {

    /**
     * Точка входа в программу
     * @param args
     */
    public static void main(String[] args) {


        String[][] array1 = new String[][] {{"1", "1", "1", "qwe"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] array2 = new String[][] {{"1", "1", "1", "1"}, {"1", "1", "qwe", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] array3 = new String[][] {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "qwe", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] array4 = new String[][] {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"qwe", "1", "1", "1"}};

        String[][] array5 = new String[3][3];

        String[][] array6 = new String[][] {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {

            /**
             * Ниже для проверки оставил разные массивы
             */

            //System.out.println(ArraySum(array1));
            //System.out.println(ArraySum(array2));
            //System.out.println(ArraySum(array3));
            //System.out.println(ArraySum(array4));
            //System.out.println(ArraySum(array5));
            System.out.println("Сумма всех элементов " + ArraySum(array6));


        } catch (MyArraySizeException exception) {

            System.out.println("Ошибка с размерами массива");
            System.out.println(exception.getMessage());

        } catch (MyArrayDataException exception) {

            System.out.println("Ошибка с элементом массива: " + exception.posX + " " + exception.posY + ". Текущее сумма элементов до возникновения ошибки " + exception.result);
            System.out.println(exception.getMessage());

        }

    }

    /**
     * Метод складывающий сумму элементов массива
     * @param array массив 4х4
     * @return возвращаем резульат сложения
     * @throws MyArrayDataException Ошибка размерности массива
     * @throws MyArraySizeException Ошибка элемента массива, элемент не является числом
     */
    public static int ArraySum(String[][] array) throws MyArrayDataException, MyArraySizeException {

        int result = 0;

        if (array.length != 4 || array[0].length != 4)
            throw new MyArraySizeException("Массив должен быть 4х4");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                if (isNumber(array[i][j])) {

                    result += Integer.parseInt(array[i][j]);

                } else {

                    throw new MyArrayDataException("Элемент массива не являеться числом", i, j, result);

                }

            }
        }

        return result;
    }

    /**
     * Метод для проверки являеться ли строка числом
     * @param string строка которую проверяем
     * @return возвращаем истину или ложь
     */
    public static boolean isNumber(String string) {
        boolean result;

        try {

            int x = Integer.parseInt(string);
            result = true;

        } catch (NumberFormatException exception) {

            result = false;

        }

        return result;
    }

}

/**
 * Исключение связанное с размерностью массива
 */
class MyArraySizeException extends Exception {

    MyArraySizeException(String message) {
        super(message);
    }

}

/**
 * Исключение связаное с элементом массива, а именно элемент не является числом
 */
class MyArrayDataException extends Exception{

    int posX;
    int posY;
    int result;

    MyArrayDataException(String message, int posX, int posY, int result) {
        super(message);
        this.posX = posX;
        this.posY = posY;
        this.result = result;
    }

}