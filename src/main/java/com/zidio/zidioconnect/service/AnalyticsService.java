package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.AnalyticsResponse;
import com.zidio.zidioconnect.dto.PaymentAnalyticsDTO;

public interface AnalyticsService {
    AnalyticsResponse getAnalyticsData();
    PaymentAnalyticsDTO getPaymentAnalytics();
}
