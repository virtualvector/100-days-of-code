from fractions import gcd
def multiplicative_inverse(e, phi):
    d = 0 
    x1 = 0 
    x2 = 1 
    y1 = 1 
    temp_phi = phi 
    
    while e > 0:
        temp1 = temp_phi/e
        temp2 = temp_phi - temp1 * e 
        temp_phi = e 
        e = temp2
    
        x = x2- temp1* x1
        y = d - temp1 * y1
    
        x2 = x1
        x1 = x 
        d = y1
        y1 = y 
    
    if temp_phi == 1:
        return d + phi

p=41

q=43

n = p*q
phi =(p-1)*(q-1)

e=5

while(e<phi):
    if(gcd(phi,e)!=1):
        e+=1
    else: break

print e, gcd(phi,e)

msg = int(raw_input())

enc = (msg**e)%n
print enc, "is the encrypted msg"

d_key = multiplicative_inverse(e,phi)

print d_key, "is decryption key"

final_msg = enc**d_key % n
print final_msg, "is the decrypted msg"


