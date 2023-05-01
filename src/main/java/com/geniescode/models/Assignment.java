package com.geniescode.models;

import java.time.LocalDate;

public record Assignment(int id, int courseId, String name, LocalDate deadline) {
}
