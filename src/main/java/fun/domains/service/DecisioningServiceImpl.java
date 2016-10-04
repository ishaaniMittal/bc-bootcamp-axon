package fun.domains.service;

import fun.data.vo.ApplicationVO;
import org.springframework.stereotype.Component;

/**
 * Created by imittal on 10/4/16.
 */
@Component
public class DecisioningServiceImpl implements DecisioningService {
    @Override
    public boolean getDecision(ApplicationVO applicationVO) {
        if (applicationVO.getApplicationId().hashCode() % 2 == 0) {
            return true;
        }
        return true;
    }
}
