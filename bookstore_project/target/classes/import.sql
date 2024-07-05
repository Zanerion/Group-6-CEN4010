-- Insert users if they don't exist
INSERT IGNORE INTO user (userName, userPassword, name, email, address) VALUES 
('Roses', 'RosesAreRed34', 'Rosie Harry', 'RosesRed34@gmail.com', 'garden street'),
('Gary', 'applesForever46', 'Gary King', 'garyTheMan@gmail.com', 'tech avenue'),
('second Gary', 'applesForever46', 'Gary King', 'garyTheMan@gmail.com', 'tech avenue'),
('sirennnsss', 'potOfFools', 'Johnny', 'johnJohn@hotmail.com', 'Penny Lane street'),
('UpMore', 'pittypatter', 'mina', 'mirandalor@live.com', 'arry avenue'),
('Krill', 'lovelyTrees@@', 'Kermit Hans', 'kHans45@gmail.com', 'ocean avenue'),
('tim', 'yourBoyTimmy', 'timmy', 'timmy78@gmail.com', 'new avenue'),
('tim2', 'secondBoyTimmy', 'timmy', 'timmy78@gmail.com', 'new avenue'),
('emilia56', 'emily89', 'emma fruit', 'emilya@yahoo.com', 'ferris street'),
('kevin', 'gogoFruit98', 'Kevin Hall', 'kHall@gmail.com', '5th avenue');

-- Insert payments for specific users
INSERT IGNORE INTO payment (cardNumber, cardHolderName, bankName, userName) VALUES 
('1234567890123456', 'Rosie Harry', 'Chase Bank', 'Roses'),
('9876543210987654', 'Gary King', 'Bank Of America', 'Gary');

