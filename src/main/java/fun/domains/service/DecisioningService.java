package fun.domains.service;

import fun.data.vo.ApplicationVO;

/**
 * Created by imittal on 10/3/16.
 */
public interface DecisioningService {
    boolean getDecision(ApplicationVO applicationVO);
}
