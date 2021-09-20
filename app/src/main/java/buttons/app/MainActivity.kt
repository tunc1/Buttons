package buttons.app

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.service.quicksettings.TileService
import androidx.appcompat.app.AppCompatActivity

class MainActivity:AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val devicePolicyManager:DevicePolicyManager=applicationContext.getSystemService(TileService.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val component=ComponentName(this,Admin::class.java)
        if(!devicePolicyManager.isAdminActive(component))
        {
            val permissionIntent=Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
            permissionIntent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,component)
            permissionIntent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,"Application needs this permission")
            startActivity(permissionIntent)
        }
        finish()
    }
}