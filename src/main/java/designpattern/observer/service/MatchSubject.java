package designpattern.observer.service;

import designpattern.observer.core.MatchData;
import designpattern.observer.core.Observer;
import designpattern.observer.core.Subject;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;

import java.util.LinkedHashSet;
import java.util.Set;

@Log
@EqualsAndHashCode
public class MatchSubject implements Subject<MatchData> {
    private Set<Observer<MatchData>> observers = new LinkedHashSet<>();
    private MatchData matchData = new MatchData();

    @Override
    public void registerObserver(Observer<MatchData> matchDataObserver) {
        observers.add(matchDataObserver);
    }

    @Override
    public void unregisterObserver(Observer<MatchData> matchDataObserver) {
        log.info(String.valueOf(observers.contains(matchDataObserver)));
        observers.remove(matchDataObserver);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.updateInformation(matchData));
    }

    public void updateResults(int penalties, int goals, int remainingTime) {
        matchData.setGoals(goals);
        matchData.setPenalties(penalties);
        matchData.setRemainingTimeMinutes(remainingTime);

        notifyObservers();
    }
}
