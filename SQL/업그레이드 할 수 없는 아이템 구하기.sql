select i.ITEM_ID, i.ITEM_NAME, i.RARITY
from ITEM_INFO i
where i.ITEM_ID not in (
    select distinct PARENT_ITEM_ID
    from ITEM_TREE
    where PARENT_ITEM_ID is not null
)
order by 1 desc