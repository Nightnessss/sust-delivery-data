package com.fehead.sustdelivery.controller;

import com.fehead.sustdelivery.dao.UserDOMapper;
import com.fehead.sustdelivery.dataobject.UserDO;
import com.fehead.sustdelivery.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 写代码 敲快乐
 * だからよ...止まるんじゃねぇぞ
 * ▏n
 * █▏　､⺍
 * █▏ ⺰ʷʷｨ
 * █◣▄██◣
 * ◥██████▋
 * 　◥████ █▎
 * 　　███▉ █▎
 * 　◢████◣⌠ₘ℩
 * 　　██◥█◣\≫
 * 　　██　◥█◣
 * 　　█▉　　█▊
 * 　　█▊　　█▊
 * 　　█▊　　█▋
 * 　　 █▏　　█▙
 * 　　 █
 *
 * @author Nightnessss 2019/10/16 19:09
 */
@RequestMapping("/api/v1.0/SUSTDelivery/data")
@RestController
public class LoginController extends BaseController {


    @Autowired
    private UserDOMapper userDOMapper;

    @GetMapping("/login/thirdPartyId")
    public UserModel alreadyLogin(@RequestParam("thirdPartyId") String thirdPartyId) {

        UserDO userDO = userDOMapper.selectUserByThirdPartyId(thirdPartyId);
        if (userDO == null) {
            return null;
        } else {
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(userDO, userModel);
            return userModel;
        }

    }

    @PostMapping("/login/addUser")
    public int addUser(@RequestBody UserModel userModel) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel, userDO);
        userDOMapper.insertUserInfo(userDO);
        return userDO.getId();
    }

    @PostMapping("/login/addInfo")
    public int addInfo(@RequestBody UserModel userModel) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel, userDO);
        userDOMapper.updateUserInfo(userDO);
        System.out.println(userDO.toString());
        return userDO.getId();

    }
}
