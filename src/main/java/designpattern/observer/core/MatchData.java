package designpattern.observer.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MatchData {
    private int goals;
    private int penalties;
    private int remainingTimeMinutes;
}
