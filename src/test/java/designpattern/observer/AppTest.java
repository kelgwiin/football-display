package designpattern.observer;

import designpattern.observer.core.MatchData;
import designpattern.observer.service.LiveDisplay;
import designpattern.observer.service.MatchSubject;
import designpattern.observer.service.TotalDisplay;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    private MatchSubject matchSubject;
    private LiveDisplay liveDisplay;
    private TotalDisplay totalDisplay;

    @Before
    public void init(){
        matchSubject = new MatchSubject();
        liveDisplay = new LiveDisplay(matchSubject);
        totalDisplay = new TotalDisplay(matchSubject);
    }
    @Test
    public void itShouldShowDataBothSubscribers() {
        matchSubject.updateResults(1, 0, 45);
        matchSubject.updateResults(3, 2, 40);

        MatchData matchDataLiveResult = liveDisplay.displayResult();
        MatchData matchDataTotalResult = totalDisplay.displayResult();

        //Live Comparison
        assertEquals(3, matchDataLiveResult.getPenalties());
        assertEquals(2, matchDataLiveResult.getGoals());
        assertEquals(40, matchDataLiveResult.getRemainingTimeMinutes());

        //Total
        assertEquals(4, matchDataTotalResult.getPenalties());
        assertEquals(2, matchDataTotalResult.getGoals());
        assertEquals(40, matchDataTotalResult.getRemainingTimeMinutes());
    }

    @Test
    public void itShouldNotShowDataForUnsubscribedLiveDisplay() {
        matchSubject.updateResults(1, 0, 45);
        matchSubject.updateResults(3, 2, 40);

        matchSubject.unregisterObserver(liveDisplay);
        matchSubject.updateResults(2, 1, 35);

        MatchData matchDataLiveResult = liveDisplay.displayResult();
        MatchData matchDataTotalResult = totalDisplay.displayResult();

        //Live Display
        assertEquals(3, matchDataLiveResult.getPenalties());
        assertEquals(2, matchDataLiveResult.getGoals());
        assertEquals(40, matchDataLiveResult.getRemainingTimeMinutes());

        //Total Display
        assertEquals(6, matchDataTotalResult.getPenalties());
        assertEquals(3, matchDataTotalResult.getGoals());
        assertEquals(35, matchDataTotalResult.getRemainingTimeMinutes());
    }
}
