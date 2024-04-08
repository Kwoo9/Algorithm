SELECT ai.ANIMAL_ID, ai.ANIMAL_TYPE, ao.NAME
from ANIMAL_INS ai, ANIMAL_OUTS ao
where ai.ANIMAL_ID = ao.ANIMAL_ID 
and ai.SEX_UPON_INTAKE not in ("Spayed Female", "Neutered Male")
and ao.SEX_UPON_OUTCOME in ("Spayed Female", "Neutered Male")