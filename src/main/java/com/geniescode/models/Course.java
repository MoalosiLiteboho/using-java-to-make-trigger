package com.geniescode.models;

import java.time.LocalDate;

public record Course(int id, String name, LocalDate retire) {
}
