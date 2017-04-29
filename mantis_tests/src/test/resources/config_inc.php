<?php
$g_hostname               = 'localhost';
$g_db_type                = 'mysqli';
$g_database_name          = 'bugtracker';
$g_db_username            = 'root';
$g_db_password            = '';

$g_default_timezone       = 'Europe/Berlin';

$g_crypto_master_salt     = 'Zv7hvWGY9YQPiYwM3/zQbIEuEwK2FpvYZ4eagVPs80A=';
$g_signup_use_captcha     = OFF;

$g_phpMailer_Method       = PHPMAILER_METHOD_SMTP;
$g_smtp_host              = 'localhost';
$g_smtp_port              = 25;
$g_smtp_username          = 'root';
$g_smtp_password          = 'root';

$g_log_level = LOG_EMAIL | LOG_EMAIL_RECIPIENT;
$g_log_destination = 'file:c:\xampp\htdocs\mantisbt-2.3.1\mantisbt.log';

$g_allow_signup = ON; //allows the users to sign up for a new account
$g_enable_email_notification = ON; //enables the email messages