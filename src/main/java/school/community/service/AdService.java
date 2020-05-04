package school.community.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.community.mapper.AdMapper;
import school.community.model.Ad;
import school.community.model.AdExample;

import java.util.List;

/**
 * Created by codedrinker on 2019/9/6.
 */
@Service
public class AdService {
    @Autowired
    private AdMapper adMapper;

    public List<Ad> list(String pos) {
        AdExample navExample = new AdExample();
        navExample.createCriteria()
                .andStatusEqualTo(1)
                .andPosEqualTo(pos)
                .andGmtStartLessThan(System.currentTimeMillis())
                .andGmtEndGreaterThan(System.currentTimeMillis());
        return adMapper.selectByExample(navExample);
    }
}
