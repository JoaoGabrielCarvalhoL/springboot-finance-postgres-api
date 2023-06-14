package br.com.carv.finance.mapper;

import org.mapstruct.Mapper;

import br.com.carv.finance.model.dto.request.UserPostRequest;
import br.com.carv.finance.model.dto.request.UserPutRequest;
import br.com.carv.finance.model.dto.response.UserResponse;
import br.com.carv.finance.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponse toUserResponse(User user);
	
	User toUser(UserPostRequest userPostRequest);
	
	User toUser(UserPutRequest userPutRequest);

}
