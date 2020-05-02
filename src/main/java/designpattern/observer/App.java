package designpattern.observer;

import designpattern.observer.service.LiveDisplay;
import designpattern.observer.service.MatchSubject;
import designpattern.observer.service.TotalDisplay;
import lombok.extern.java.Log;

/**
 * @author Kelwin Gamez - kelgwiin
 */
@Log
public class App {
    public static void main(String[] args) {
        MatchSubject matchSubject = new MatchSubject();

        LiveDisplay liveDisplay = new LiveDisplay(matchSubject);
        TotalDisplay totalDisplay = new TotalDisplay(matchSubject);

        matchSubject.updateResults(1, 0, 45);
        display(liveDisplay, totalDisplay);

        matchSubject.updateResults(3, 2, 40);
        display(liveDisplay, totalDisplay);

        matchSubject.unregisterObserver(liveDisplay);
        matchSubject.updateResults(0, 1, 35);
        display(liveDisplay, totalDisplay);
    }

    private static void display(LiveDisplay liveDisplay, TotalDisplay totalDisplay) {
        log.info("Live Display: " + liveDisplay.displayResult());
        log.info("Total Display: " + totalDisplay.displayResult() + "\n");
    }
}
