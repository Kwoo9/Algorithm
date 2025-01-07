SELECT concat("/home/grep/src/", a.BOARD_ID, "/", b.FILE_ID, b.FILE_NAME, b.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD a, USED_GOODS_FILE b
where a.BOARD_ID = b.BOARD_ID and a.VIEWS = (select max(views) from USED_GOODS_BOARD)
order by b.FILE_ID desc