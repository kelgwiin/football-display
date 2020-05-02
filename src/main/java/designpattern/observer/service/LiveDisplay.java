package designpattern.observer.service;

import designpattern.observer.core.Display;
import designpattern.observer.core.MatchData;
import designpattern.observer.core.Observer;

public class LiveDisplay implements Observer<MatchData>, Display<MatchData> {
    private MatchSubject matchSubject;
    private MatchData matchData;

    public LiveDisplay(MatchSubject matchSubject) {
        this.matchData = new MatchData();
        this.matchSubject = matchSubject;
        matchSubject.registerObserver(this);
    }

    @Override
    public void updateInformation(MatchData data) {
        matchData.setGoals(data.getGoals());
        matchData.setPenalties(data.getPenalties());
        matchData.setRemainingTimeMinutes(data.getRemainingTimeMinutes());
    }

    @Override
    public MatchData displayResult() {
        return matchData;
    }
}
