package com.rainard.grindhouse.model;

import java.net.URI;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Problem {
    String messageTitle;
    String detail;
    URI instance;
}
