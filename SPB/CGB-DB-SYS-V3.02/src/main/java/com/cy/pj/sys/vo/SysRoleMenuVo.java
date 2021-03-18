package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 基于角色id从数据库获取数据，然后封装到此对象，方案分析
 * 1)业务层发起多次查询，最后将结果封装到SysRoleMenuVo对象。(最简单)
 * 2)数据层执行嵌套查询，最后将结果封装到SysRoleMenuVo对象。(相对较难)
 * 3)数据层执行多表关联查询，最后将结果封装到SysRoleMenuVo对象。(相对较难)
 */
@Data
@NoArgsConstructor
public class SysRoleMenuVo implements Serializable{
	private static final long serialVersionUID = -9146663128687049791L;
	private Integer id;
    private String name;
    private String note;
    /**角色对应的菜单id*/
    private List<Integer> menuIds;

}
