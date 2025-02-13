package com.librarymanagement.loan.ui.dto.response;

import lombok.Getter;

@Getter
public class GetDelayPenaltyHttpResponse {

    private int delayPenalty;

    public GetDelayPenaltyHttpResponse(int delayPenalty) {
        this.delayPenalty = delayPenalty;
    }
}
