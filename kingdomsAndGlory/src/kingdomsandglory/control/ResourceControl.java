/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdomsandglory.control;

import kingdomsandglory.model.Resource;
import kingdomsandglory.model.ResourceEnum;

/**
 *
 * @author piano
 */
public class ResourceControl {
    public static Resource[] createItems() {
        Resource[] resourceType = new Resource[5];

        Resource cloth = new Resource();
        cloth.resourceQty = 0.0;
        cloth.resourceDiscription = "cloth";
        resourceType[ResourceEnum.cloth.ordinal()] = cloth;

        Resource wood = new Resource();
        wood.resourceQty = 0.0;
        wood.resourceDiscription = "wood";
        resourceType[ResourceEnum.wood.ordinal()] = wood;

        Resource stone = new Resource();
        stone.resourceQty = 0.0;
        stone.resourceDiscription = "stone";
        resourceType[ResourceEnum.stone.ordinal()] = stone;

        Resource metal = new Resource();
        metal.resourceQty = 0.0;
        metal.resourceDiscription = "metal";
        resourceType[ResourceEnum.metal.ordinal()] = metal;

        Resource gold = new Resource();
        gold.resourceQty = 0.0;
        gold.resourceDiscription = "gold";
        resourceType[ResourceEnum.gold.ordinal()] = gold;

        return resourceType;
    }
}
