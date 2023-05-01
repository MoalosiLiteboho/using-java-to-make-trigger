package com.geniescode.id;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class IdGenerator implements Function<List<Integer>, Integer> {
    public Integer apply(List<Integer> idList) {
        AtomicInteger counter = new AtomicInteger();
        int id = counter.incrementAndGet();

        while (idList.contains(id)) id = counter.incrementAndGet();
        return id;
    }
}
