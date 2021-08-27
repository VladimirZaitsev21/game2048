package ru.zvo.game.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class GameHelper {

    //Метод сдвига элементов игрового поля и складывания одинаковых
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        if (isListEmpty(list)) {
            return list;
        }
        List<Integer> newList = transferNulls(list);
        return mergeElements(newList);
    }

    //метод заполнения списка пустыми значениями до нужной длины
    private void appendNulls(List<Integer> sourceList, List<Integer> newList) {
        int sizeDifference = sourceList.size() - newList.size();
        for (int i = 0; i < sizeDifference; i++) {
            newList.add(null);
        }
    }

    //метод перемещения пустых значений в конец списка
    private List<Integer> transferNulls(List<Integer> list) {
        List<Integer> transferredList = new ArrayList<>();
        for (Integer element : list) {
            if (element != null) {
                transferredList.add(element);
            }
        }
        appendNulls(list, transferredList);
        return transferredList;
    }

    //Метод складывания одинаковых элементов
    private List<Integer> mergeElements(List<Integer> list) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0;
        while (i < (list.size() - 1) && (list.get(i) != null)) {
            //Если элемент равен элементу, стоящему за ним
            if (list.get(i).equals(list.get(i + 1))) {
                mergedList.add(list.get(i) * 2);
                i += 2;
            } else {
                mergedList.add(list.get(i));
                if (i == (list.size() - 2)) {
                    mergedList.add(list.get(i + 1));
                }
                i++;
            }
        }
        //добавляем пустые значения
        appendNulls(list, mergedList);
        return mergedList;
    }

    private boolean isListEmpty(List<Integer> list) {
        if (list.equals(Collections.EMPTY_LIST)) {
            return true;
        } else {
            return isListRepresentedByNulls(list);
        }
    }

    private boolean isListRepresentedByNulls(List<Integer> list) {
        for (Integer element : list) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

}