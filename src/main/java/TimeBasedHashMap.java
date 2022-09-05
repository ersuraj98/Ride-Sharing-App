import java.sql.DataTruncation;
import java.util.*;


/*
@author Suraj Kumar Jha (surajjha1998@gmail.com)
@version v1

Interviewer : Bhanu Walia ( bhanu.walia@nykaa.com )


Q) Design a time series hashmap which supports one extra function of getting the value of a key at a particular moment in time in the hashmap.

1) put(key, value)
2) get(key)
3) get(key, time)

Eg:

T=100 put("a","valueA")

T=101 get("a") returns "valueA"

T=105 put("a", "newValueA")

T=106 get("a") returns "newValueA"

T=107 get("a", 102) returns "valueA"
3) get(key, time)




*/
public class TimeBasedHashMap {

    Map<String, Object> storageMap = new HashMap<>();

    public void put(String key, String value) { // O(T) - T - no of time you update the key.

        if (storageMap.containsKey(key)) {
            List<Intervals> intervals = (List<Intervals>) storageMap.get(key);

            List<Intervals> temp = new ArrayList<>();

            for (Intervals intervalsValue : intervals) {
                if (intervalsValue.getEndTime() == null) {
                    intervalsValue.setEndTime(new Date().getTime());
                }
                temp.add(intervalsValue);
            }
            Intervals currentIntervals = new Intervals();
            currentIntervals.setStartTime(new Date().getTime());
            currentIntervals.setValue(value);
            temp.add(currentIntervals);

            storageMap.put(key, temp);

        } else {
            Intervals intervals = new Intervals();
            intervals.setStartTime(new Date().getTime());
            intervals.setValue(value);
            List<Intervals> arrayIntervals = new ArrayList<>();
            arrayIntervals.add(intervals);
            storageMap.put(key, arrayIntervals);
        }
    }

    public void put1(String key, String value) { // O(T) - T - no of time you update the key. // Optimized

        if (storageMap.containsKey(key)) {
            List<Intervals> intervals = (List<Intervals>) storageMap.get(key);

            List<Intervals> temp = new ArrayList<>();

            for (Intervals intervalsValue : intervals) {
                if (intervalsValue.getEndTime() == null) {
                    intervalsValue.setEndTime(new Date().getTime());
                }
                temp.add(intervalsValue);
            }
            Intervals currentIntervals = new Intervals();
            currentIntervals.setStartTime(new Date().getTime());
            currentIntervals.setEndTime(null);
            currentIntervals.setValue(value);
            temp.add(currentIntervals);

            storageMap.put(key, temp);

        } else {
            Intervals intervals = new Intervals();
            intervals.setStartTime(new Date().getTime());
            intervals.setValue(value);
            List<Intervals> arrayIntervals = new ArrayList<>();
            arrayIntervals.add(intervals);
            storageMap.put(key, arrayIntervals);
        }
    }

    public String get(String key) {
        if (storageMap.containsKey(key)) {
            List<Intervals> intervals = (List<Intervals>) storageMap.get(key);

            for (Intervals intervalsValue : intervals) {
                if (intervalsValue.getEndTime() == null) {
                    return intervalsValue.getValue();
                }
            }
        }
        return null;
    }

    public String get(String key, Long timestamp) { // O(logn)
        if (storageMap.containsKey(key)) {
            List<Intervals> intervals = (List<Intervals>) storageMap.get(key);

            int low = 0, high = intervals.size() - 1;

            while (low <= high) {

                int mid = ( low + high ) / 2;

                Intervals intervals1 =  intervals.get(mid);

                if (timestamp < intervals1.getStartTime() ) {
                    high = mid - 1;
                } else if (intervals1.getEndTime() != null && timestamp > intervals1.getEndTime()) {
                    low = mid + 1;
                } else {
                    return intervals1.getValue();
                }

            }
        }
        return null;
    }

}
