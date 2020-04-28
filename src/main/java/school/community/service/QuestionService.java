package school.community.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.community.dto.PaginationDTO;
import school.community.dto.QuestionDTO;
import school.community.mapper.QuestionMapper;
import school.community.mapper.UserMapper;
import school.community.model.Question;
import school.community.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:cdx
 * @Date:2020-04-25
 * @Description:school.community.service
 * @Version:1.0
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();


        Integer totalPage;
        //总数量
        Integer totalCount=questionMapper.count();
        if(totalCount % size ==0){
            totalPage = totalCount/size;
        }else {
            totalPage=totalCount/size+1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        paginationDTO.setPagination(totalPage,page);
        //size*(page -1)每页数据条数
        Integer offset = size * (page-1);
        List<Question> questions=questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questions){
            User user =userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        //总数量
        Integer totalCount=questionMapper.countByUserId(userId);
        if(totalCount % size ==0){
            totalPage = totalCount/size;
        }else {
            totalPage=totalCount/size+1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        paginationDTO.setPagination(totalPage,page);

        //size*(page -1)每页数据条数
        Integer offset = size * (page-1);
        List<Question> questions=questionMapper.listByUserId(userId,offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questions){
            User user =userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;

    }

    public QuestionDTO getById(Integer id) {

        Question question=questionMapper.getById(id);
        QuestionDTO questionDTO=new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user =userMapper.findById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }
}
