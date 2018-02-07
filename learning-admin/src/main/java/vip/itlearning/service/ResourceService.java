package vip.itlearning.service;

import vip.itlearning.model.system.Resource;

import java.util.List;

public interface ResourceService {
        List<String> findPermissions(List<Long> resourceIds); //得到资源对应的权限字符串
        List<Resource> findMenus(List<String> permissions); //根据用户权限得到菜单
}
