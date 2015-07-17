package kz.petsclinic.clinic.collection;

import kz.petsclinic.clinic.Person;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Коллекция для работы с Персонами,
 * простое подобие ArrayList
 */
public class PersonCollection {

    /**
     * начальный размер
     * массива по умолчанию
     */
    private final static int DEFAULT_DATA_CAPACITY = 10;
    /**
     * размер валидной части
     * масиива data
     */
    private int size = 0;

    /**
     * масссив класса Person
     */
    private Person[] data;
    final ReentrantLock lock = new ReentrantLock();

    public PersonCollection() {
        data = new Person[DEFAULT_DATA_CAPACITY];
    }

    /**
     *
     * @return размер валидной
     * части массива
     */
    public int getSize() {
        return size;
    }

    /**
     * Получить Персону по индексу
     * @param index индекс нужной
     * Персоны
     * @return запрошенную персону
     */
    public Person get(final int index) {
        lock.lock();
        try {
            checkRange(index);
            return data[index];
        } finally {
            lock.unlock();
        }
    }

    /**
     * Добавление новой Персоны
     * в массив
     * @param person Новая Персона
     */
    public void add(final Person person) {
        lock.lock();
        try {
            checkCapacity();
            data[size++] = person;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Удаление Персоны по
     * звданному индексу
     * @param index индекс
     * удаляемой персоны
     */
    public void remove(final int index) {
        lock.lock();
        try {
            checkRange(index);
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            data[--size] = null;
        } finally {
            lock.unlock();
        }
    }

    /**
     * проверка пуст ли
     * валидный массив
     * @return true если пуст,
     * false если нет
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Получение Id Персоны массива
     * сходного с заданныой Персоной
     * @param person заданная Персона
     * @return Id Пероны или -1 если
     * такая Персона не найдена
     */
    public int getPersonId(Person person) {
        lock.lock();
        try {
            int result = -1;
            for (int i = 0; i < size; i++) {
                if (data[i].equals(person)) result = i;
            }
            return result;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Переопределенный toString
     * для вывода всего массива
     * @return
     */
    @Override
    public String toString() {
        lock.lock();
        try {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sBuilder.append("[ " + i + ": " + data[i].toString() +" ]\n");
        }
        return sBuilder.toString();
        } finally {
            lock.unlock();
        }
    }

    /**
     * проверка не выйдет ли
     * размер валидного массива
     * за размер реального при добавлении
     * нового элемента,
     * и вызов метода "увеличивающиего"
     * реальный массив если выходит
     */
    private void checkCapacity() {
        if (size + 1 > data.length)
            increaseCapacity();
    }

    /**
     * "увеличение" размера реального
     * массива
     */
    private void increaseCapacity() {
        Person[] newData = new Person[getNewCapacity()];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * проверка на вхождение
     * заданного индекса в валидную
     * часть массива
     * @param index индекс для проверки
     */
    private void checkRange(final int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(
                    "index " + index + " out of 0.." + size);
    }

    /**
     * новый размер для массива
     * @return новый размер
     */
    private int getNewCapacity() {
        return (data.length * 3) / 2 + 1;
    }

    /**
     *
     * @return размер
     * валидной части
     * массива
     */
    private int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }
}
