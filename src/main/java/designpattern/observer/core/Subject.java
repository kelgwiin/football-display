package designpattern.observer.core;

public interface Subject<T> {
    void registerObserver(Observer<T> matchDataObserver);

    void unregisterObserver(Observer<T> matchDataObserver);

    void notifyObservers();
}
