package live.zeballos.reserva.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Long> parseIdList(String ids) {
        List<Long> idList = new ArrayList<>();
        if (ids != null && !ids.isEmpty()) {
            idList = Arrays.stream(ids.split(","))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        }
        return idList;
    }
}
