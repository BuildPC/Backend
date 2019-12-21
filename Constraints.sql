/* Triggers */
DELIMITER //

CREATE TRIGGER assign_Basket
AFTER INSERT ON users FOR EACH ROW
BEGIN
  IF new.email IS NOT NULL THEN INSERT INTO Basket(username) VALUES(new.email);
  END IF;
END; //

DELIMITER ;


DELIMITER //

CREATE TRIGGER check_Stock
BEFORE INSERT ON BContains FOR EACH ROW
BEGIN
	DECLARE val INT;
    IF NEW.item_id IN (SELECT I.item_id
    				FROM Item I
                    WHERE NEW.item_id = I.item_id AND NEW.amount <= I.stock) THEN SET val = 1;
    ELSE SET new.item_id = NULL;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER check_StockOnUpdate
BEFORE UPDATE ON BContains FOR EACH ROW
BEGIN
	DECLARE val INT;
    IF NEW.item_id IN (SELECT I.item_id
    				FROM Item I
                    WHERE NEW.item_id = I.item_id AND NEW.amount <= I.stock) THEN SET val = 1;
    ELSE SET new.item_id = NULL;
    END IF;
END //

DELIMITER ;

/* Procedures */
DELIMITER //

CREATE PROCEDURE addBasket(IN username VARCHAR(255), IN itemID INT,IN new_amount INT)
BEGIN
	DECLARE basketId INT;
    
    SELECT MAX(B.basket_id)
    INTO basketId
    FROM Basket B 
    WHERE B.username = username;
    
    IF itemID NOT IN (SELECT B.item_id FROM BContains B WHERE B.basket_id = basketId AND B.item_id = itemID ) THEN INSERT INTO BContains (amount,basket_id,item_id) VALUES (new_amount,basketID,itemID);
    ELSE UPDATE BContains SET amount = amount + new_amount WHERE item_id = itemID AND basket_id = basketId;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE removeFromBasket(IN username VARCHAR(255), IN itemID INT)
BEGIN
	DECLARE basketId INT;
    
    SELECT MAX(B.basket_id)
    INTO basketId
    FROM Basket B 
    WHERE B.username = username;
    
    DELETE FROM BContains WHERE item_id = itemID AND basket_id = basketId;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE purchaseBasket(IN username VARCHAR(255))
BEGIN
	DECLARE basketId INT;
    
    SELECT MAX(B.basket_id)
    INTO basketId
    FROM Basket B 
    WHERE B.username = username;
    
    INSERT INTO History (basket_id) VALUES (basketId);
    INSERT INTO Basket (username) VALUES (username);
    
END //

DELIMITER ;