package fun.data;

import fun.data.vo.ApplicationVO;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by imittal on 10/3/16.
 */
@Component
public class ApplicationDaoImpl implements ApplicationDao {

    ConcurrentHashMap<String, ApplicationVO> applications = new ConcurrentHashMap<>();

    @Override
    public void saveApplication(String applicationId, ApplicationVO application) {
        applications.put(applicationId, application);
    }

    @Override
    public ApplicationVO getApplication(String applicationId) {
        return applications.get(applicationId);
    }
}
