package com.davis.shift.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class UserArrange {
    private UserBO user;
    private Map<String,ArrangeBO> arrangeMap = new HashMap<>();
}
