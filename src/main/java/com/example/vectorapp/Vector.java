package com.example.vectorapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Vector {
    private ArrayList<Integer> data;

    public Vector() {
        data = new ArrayList<>();
    }

    // Cargar desde un arreglo
    public void cargar(int[] arr) {
        data.clear();
        for (int v : arr) data.add(v);
    }

    // Mostrar (retorna copia)
    public int[] mostrar() {
        int[] res = new int[data.size()];
        for (int i = 0; i < data.size(); i++) res[i] = data.get(i);
        return res;
    }

    public void adicionar(int value) { data.add(value); }

    public boolean insertar(int index, int value) {
        if (index < 0 || index > data.size()) return false;
        data.add(index, value);
        return true;
    }

    public Integer obtener(int index) {
        if (index < 0 || index >= data.size()) return null;
        return data.get(index);
    }

    public int cantidad() { return data.size(); }

    public void invertir() {
        Collections.reverse(data);
    }

    // Rotar a la derecha k posiciones
    public void rotar(int k) {
        int n = data.size();
        if (n == 0) return;
        k = ((k % n) + n) % n;
        if (k == 0) return;
        ArrayList<Integer> tmp = new ArrayList<>(data.subList(n - k, n));
        tmp.addAll(data.subList(0, n - k));
        data = tmp;
    }

    public int busquedaSecuencial(int value) {
        for (int i = 0; i < data.size(); i++) if (data.get(i) == value) return i;
        return -1;
    }

    // Asume data ordenado ascendentemente
    public int busquedaBinaria(int value) {
        int left = 0, right = data.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = data.get(mid);
            if (midVal == value) return mid;
            if (midVal < value) left = mid + 1; else right = mid - 1;
        }
        return -1;
    }

    // Ordenamientos
    public void ordenarInsercion() {
        for (int i = 1; i < data.size(); i++) {
            int key = data.get(i);
            int j = i - 1;
            while (j >= 0 && data.get(j) > key) {
                data.set(j + 1, data.get(j));
                j--;
            }
            data.set(j + 1, key);
        }
    }

    public void ordenarSeleccion() {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) if (data.get(j) < data.get(minIdx)) minIdx = j;
            int tmp = data.get(i);
            data.set(i, data.get(minIdx));
            data.set(minIdx, tmp);
        }
    }

    public void ordenarIntercambio() { // similar a burbuja básica con intercambio
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (data.get(i) > data.get(j)) {
                    int tmp = data.get(i);
                    data.set(i, data.get(j));
                    data.set(j, tmp);
                }
            }
        }
    }

    public void ordenarBurbuja() {
        int n = data.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    int tmp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, tmp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public void ordenarQuickSort() {
        quickSort(0, data.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int p = partition(low, high);
            quickSort(low, p - 1);
            quickSort(p + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = data.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                int tmp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, tmp);
            }
        }
        int tmp = data.get(i + 1);
        data.set(i + 1, data.get(high));
        data.set(high, tmp);
        return i + 1;
    }

    public void eliminarRep() {
        ArrayList<Integer> seen = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer v : data) {
            if (!seen.contains(v)) {
                seen.add(v);
                result.add(v);
            }
        }
        data = result;
    }

    public void ordenarFrec() {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer v : data) freq.put(v, freq.getOrDefault(v, 0) + 1);
        ArrayList<Integer> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return Integer.compare(fb, fa); // descendente por frecuencia
            return Integer.compare(a, b); // asc por valor
        });
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer v : unique) {
            for (int i = 0; i < freq.get(v); i++) res.add(v);
        }
        data = res;
    }

    public String comoString() {
        return data.toString();
    }
}
