package com.kolkov.post.model;

import lombok.Data;

@Data
public
class DispatchSticker {
    Long dispatchId;
    String customerName;
    Integer customerIndex;
    String customerAddress;
}