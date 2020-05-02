package designpattern.observer.service;

import designpattern.observer.core.Display;
import designpattern.observer.core.MatchData;
import designpattern.observer.core.Observer;

public class TotalDisplay implements Observer<MatchData>, Display<MatchData> {
    private MatchSubject matchSubject;
    private MatchData matchData = new MatchData();

    public TotalDisplay(MatchSubject matchSubject) {
        this.matchSubject = matchSubject;
        matchSubject.registerObserver(this);
    }

    @Override
    public void updateInformation(MatchData matchData) {
        this.matchData.setGoals(this.matchData.getGoals() + matchData.getGoals());
        this.matchData.setPenalties(this.matchData.getPenalties() + matchData.getPenalties());
        this.matchData.setRemainingTimeMinutes(matchData.getRemainingTimeMinutes());
    }

    @Override
    public MatchData displayResult() {
        return matchData;
    }

}
