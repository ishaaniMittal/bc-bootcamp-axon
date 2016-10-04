package fun.data;

import fun.data.vo.ApplicationVO;

/**
 * Created by imittal on 10/3/16.
 */

public interface ApplicationDao {

    void saveApplication(String applicationId, ApplicationVO application);

    ApplicationVO getApplication(String applicationId);
}
