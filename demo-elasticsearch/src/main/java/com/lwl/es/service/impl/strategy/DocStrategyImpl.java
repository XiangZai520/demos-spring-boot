package com.lwl.es.service.impl.strategy;

import com.lwl.es.entity.search.ESData;
import com.lwl.es.service.UpdateStrategy;
import com.lwl.es.to.TmDataInDirectUpdateTO;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * author liuweilong
 * date 2019/8/8 17:01
 * desc
 */
@Service("docUpdate")
public class DocStrategyImpl implements UpdateStrategy {
    @Override
    public void generateUpdateMap(TmDataInDirectUpdateTO updateTO, Map<String, Object> queryMap, Map<String, Object> fieldMap) {
        //更新docBelong的名字
        queryMap.put(ESData.DOC_BELONG_ID, updateTO.getEntityId());
        fieldMap.put(ESData.DOC_BELONG_TITLE, updateTO.getTitle());
    }
}
