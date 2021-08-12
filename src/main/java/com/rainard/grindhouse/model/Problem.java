package com.rainard.grindhouse.model;

import lombok.Builder;
import lombok.Data;

import java.net.URI;

@Data
@Builder
public class Problem {
    String messageTitle;
    String detail;
    URI instance;
}
