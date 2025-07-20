package com.zidio.zidioconnect.service.impl;

import com.zidio.zidioconnect.dto.AnalyticsResponse;
import com.zidio.zidioconnect.dto.PaymentAnalyticsDTO;
import com.zidio.zidioconnect.enums.JobStatus;
import com.zidio.zidioconnect.enums.PaidStatus;
import com.zidio.zidioconnect.repository.JobPostRepository;
import com.zidio.zidioconnect.repository.UserPaymentStatusRepository;
import com.zidio.zidioconnect.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private UserPaymentStatusRepository userPaymentStatusRepository;

    @Override
    public AnalyticsResponse getAnalyticsData() {
        long totalJobs = jobPostRepository.count();
        long activeJobs = jobPostRepository.countByJobStatus(JobStatus.ACTIVE);
        long inactiveJobs = jobPostRepository.countByJobStatus(JobStatus.INACTIVE);
        long filledJobs = jobPostRepository.countByJobStatus(JobStatus.FILLED);
        long closedJobs = jobPostRepository.countByJobStatus(JobStatus.CLOSED);

        long totalPayments = userPaymentStatusRepository.count();
        long paidCount = userPaymentStatusRepository.countByStatus(PaidStatus.PAID);    // Correct method call
        long unpaidCount = userPaymentStatusRepository.countByStatus(PaidStatus.UNPAID);// Correct method call

        return new AnalyticsResponse(
                totalJobs, activeJobs, inactiveJobs, filledJobs, closedJobs,
                totalPayments, paidCount, unpaidCount
        );
    }

	@Override
	public PaymentAnalyticsDTO getPaymentAnalytics() {
		// TODO Auto-generated method stub
		return null;
	}
}
